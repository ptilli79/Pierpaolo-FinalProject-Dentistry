window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_paciente_form');

    	formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            apellido: document.querySelector('#apellido').value,
            nombre: document.querySelector('#nombre').value,
            dni: document.querySelector('#dni').value,
            email: document.querySelector('#email').value,
            fecha: document.querySelector('#fechaNacimiento').value,
            domicilio: {
                            calle: document.querySelector('#calle').value,
                            numero: document.querySelector('#numero').value,
                            localidad: document.querySelector('#localidad').value,
                            provincia: document.querySelector('#provincia').value,
                        }


        };
        
        console.log('formData: ' + formData);
        
        var csrfToken = document.querySelector('meta[name="_csrf"]').content;
    	console.log('CSRF Token: ' + csrfToken);

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
            'Content-Type': 'application/json',
    		'X-CSRF-TOKEN': csrfToken
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    function findBy(id) {
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
.then(data => {
    console.log('Success:', data);
    let paciente = data;
    if (paciente.domicilio) {
        console.log('Domicilio:', paciente.domicilio);
        console.log('Calle:', paciente.domicilio.calle);
        console.log('Numero:', paciente.domicilio.numero);
        console.log('Localidad:', paciente.domicilio.localidad);
        console.log('Provincia:', paciente.domicilio.provincia);
        // more code...
              document.querySelector('#paciente_id').value = paciente.id;
              document.querySelector('#nombre').value = paciente.nombre;
              document.querySelector('#apellido').value = paciente.apellido;
              document.querySelector('#dni').value = paciente.dni;
              document.querySelector('#email').value = paciente.email;
              document.querySelector('#fechaNacimiento').value = paciente.fecha;
              document.querySelector('#calle').value = paciente.domicilio.calle;
              document.querySelector('#numero').value = paciente.domicilio.numero;
              document.querySelector('#localidad').value = paciente.domicilio.localidad;
              document.querySelector('#provincia').value = paciente.domicilio.provincia;
              document.querySelector('#div_paciente_updating').style.display = "block";
        
        // more code...
    } else {
        console.log('Domicilio object not found in the fetched data');
    }
}).catch(error => {
    alert("Error: " + error);
})
      }