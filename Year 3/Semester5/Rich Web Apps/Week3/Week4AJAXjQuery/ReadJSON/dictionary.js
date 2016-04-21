// Example A: Loading HTML files
// Step 1
// $(document).ready(function() {
//   $('#letter-a a').click(function() {
//     $('#dictionary').load('a.html');
//     return false;
//   });
// });

// Step 2
$(document).ready(function() {
  $('#letter-a a').click(function() {
    $('#dictionary').hide().load('a.html', function() {
      $(this).fadeIn();
    });
    return false;
  });
});


// Example B: Loading JSON files
// Step 1
// $(document).ready(function() {
//   $('#letter-b a').click(function() {
//     $.getJSON('b.json');
//     return false;
//   });
// });

// Step 2
// $(document).ready(function() {
//   $('#letter-b a').click(function() {
//     $.getJSON('b.json', function(data) {
//       $('#dictionary').empty();
//       $.each(data, function(entryIndex, entry) {
//         var html = '<div class="entry">';
//         html += '<h3 class="term">' + entry['term'] + '</h3>';
//         html += '<div class="part">' + entry['part'] + '</div>';
//         html += '<div class="definition">';
//         html += entry['definition'];
//         html += '</div>';
//         html += '</div>';
//         $('#dictionary').append(html);
//       });
//     });
//     return false;
//   });
// });

// Step 3
$(document).ready(function() {
  $('#letter-b a').click(function() {
    $.getJSON('b.json', function(data) {
      $('#dictionary').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div class="entry">';
        html += '<h3 class="term">' + entry['term'] + '</h3>';
        html += '<div class="part">' + entry['part'] + '</div>';
        html += '<div class="definition">';
        html += entry['definition'];
        if (entry['quote']) {
          html += '<div class="quote">';
          $.each(entry['quote'], function(lineIndex, line) {
            html += '<div class="quote-line">' + line + '</div>';
          });
          if (entry['author']) {
            html += '<div class="quote-author">' + entry['author'] + '</div>';
          }
          html += '</div>';
        }
        html += '</div>';
        html += '</div>';
        $('#dictionary').append(html);
      });
    });
    return false;
  });
});


