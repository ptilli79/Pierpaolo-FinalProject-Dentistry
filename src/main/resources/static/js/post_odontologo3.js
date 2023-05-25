$(document).ready(() => {
    $('#btn-add-new-odontologo').click(function(e) {
        e.preventDefault(); // prevent the form from submitting
        var nombre = $('#nombre').val();
        var apellido = $('#apellido').val();
        var matricula = $('#matricula').val();

        console.log('Nombre: ' + nombre);
        console.log('Apellido: ' + apellido);
        console.log('Matricula: ' + matricula);
        
        const odontologo = {
            nombre: nombre,
            apellido: apellido,
            matricula: matricula
        };

		var csrfToken = document.querySelector('meta[name="_csrf"]').content;
    	console.log('CSRF Token: ' + csrfToken);
    	
        fetch(`/odontologos`, {
            method: 'POST',
            body: JSON.stringify(odontologo),
            headers: {
                'Content-Type': 'application/json',
    		'X-CSRF-TOKEN': csrfToken
            }
        })
        .then(async response => {
    	if (!response.ok) {
        const text = await response.text();
            throw new Error(text);
    	}
    return response.json();
	})
	
        .then(data => {
            console.log('Success:', data);
            document.getElementById('response').innerHTML = "Successfully added dentist with ID: " + data.id;
            document.getElementById('response').style.display = 'block';
            $('#nombre').val('');
        	$('#apellido').val('');
        	$('#matricula').val('');
        })
        .catch((error) => {
            console.error('Error:', error);
            document.getElementById('response').innerHTML = "Error: " + error;
            document.getElementById('response').style.display = 'block';
        });
        
    });
    
});