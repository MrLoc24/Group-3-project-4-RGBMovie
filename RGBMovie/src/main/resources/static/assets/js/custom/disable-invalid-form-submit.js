"use strict";
// Disabling form submissions if there are invalid fields
(function () {
  // Fetch forms to apply custom Bootstrap
  var forms = document.querySelectorAll('.kt_forms')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })

  // Insert date and time into kt_modal_add_movie_form input/date field
  document.getElementById('openingDate').valueAsDate = new Date();
  
})()