// Example A: Loading HTML files
// Step 1
 $(document).ready(function() {
   $('#letter-a').click(function() {
     $('#dictionary').load('a.html');
     return false;
   });
 });

