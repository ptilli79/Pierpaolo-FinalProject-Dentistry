document.addEventListener('DOMContentLoaded', function () {
    const addForm = document.getElementById('add_new_odontologo');

    addForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const nombre = document.getElementById('nombre').value;
        const apellido = document.getElementById('apellido').value;
        const matricula = document.getElementById('matricula').value;
        
         // Retrieve CSRF token from HTML
		const csrfToken = document.querySelector('input[name="_csrf"]').value;
		const csrfParameter = document.querySelector('input[name="_csrf"]').name;
 

        const odontologo = {
            nombre: nombre,
            apellido: apellido,
            matricula: matricula
        };

        fetch(`/odontologos`, {
            method: 'POST',
            body: JSON.stringify(odontologo),
            headers: {
                'Content-Type': 'application/json',
    		'X-CSRF-TOKEN': csrfToken
            }
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            document.getElementById('response').innerHTML = "Successfully added dentist with ID: " + data.id;
            document.getElementById('response').style.display = 'block';
        })
        .catch((error) => {
            console.error('Error:', error);
            document.getElementById('response').innerHTML = "Error: " + error;
            document.getElementById('response').style.display = 'block';
        });
    });
});