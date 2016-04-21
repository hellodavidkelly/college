

// Example E: Sending data to the server
// Step 1
 $(document).ready(function() {
   $('#letter-e a').click(function() {
     $.get('e.php', {'term': $(this).text()}, function(data) {
       $('#dictionary').html(data);
     });
     return false;
   });
 });

// Step 2
// $(document).ready(function() {
//   $('#letter-e a').click(function() {
//     $.post('e.php', {'term': $(this).text()}, function(data) {
//       $('#dictionary').html(data);
//     });
//     return false;
//   });
// });

// Step 3
//$(document).ready(function() {
//  $('#letter-e a').click(function() {
//    $('#dictionary').load('e.php', {'term': $(this).text()});
//    return false;
//  });
//});

