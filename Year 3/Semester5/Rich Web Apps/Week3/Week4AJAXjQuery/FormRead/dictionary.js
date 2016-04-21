
// Example F: Submitting forms
// Step 1
// $(document).ready(function() {
//   $('#letter-f form').submit(function() {
//     $('#dictionary').load('f.php',
//       {'term': $('input[name="term"]').val()});
//     return false;
//   });
// });

// Step 2

$(document).ready(function() {
  $('#letter-f form').submit(function() {
    $.get('f.php', $(this).serialize(), function(data) {
      $('#dictionary').html(data);
    });
    return false;
  });
});

