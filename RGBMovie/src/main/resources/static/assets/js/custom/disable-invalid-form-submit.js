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

  // Validate of add_movie and add_screening forms input/date field
  // Add current date
  const dateControl = document.querySelector('input[type="date"]');
  dateControl.valueAsDate = new Date();  
})()