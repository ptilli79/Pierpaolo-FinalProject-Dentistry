function deleteBy(id)
		  
{
		  var csrfToken = document.querySelector('meta[name="_csrf"]').content;
    		console.log('CSRF Token: ' + csrfToken);
          const url = '/pacientes/'+ id;
          const settings = {
              //method: 'DELETE'
              method: 'DELETE',
            //body: JSON.stringify(odontologo),
            headers: {
                'Content-Type': 'application/json',
    		'X-CSRF-TOKEN': csrfToken
            }
          }
          fetch(url,settings)
          .then(response => response.json())

          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}