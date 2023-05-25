function deleteBy(id)
{
			var csrfToken = document.querySelector('meta[name="_csrf"]').content;
    		console.log('CSRF Token: ' + csrfToken);
						
          const url = '/odontologos/'+ id;
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
        .then(async response => {
            const text = await response.text();
            console.log(text); // Log the message from the server
        })

          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}