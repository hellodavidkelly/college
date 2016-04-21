$(document).ready(function() {
  $('#smith').click(function() {
    $.getJSON('smith.json', function(data) {
      $('#content').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div class="entry">';
        html += '<h3 class="term">' + entry['term'] + '</h3>';
        if (entry['date']) {
          html += '<div class="date">';
          $.each(entry['date'], function(lineIndex, line) {
            html += '<div class="date">' + line + '</div>';
          });
          html += '</div>';
        }
        else if (entry['info']) {
		  html += '<div class="info">';
		  $.each(entry['info'], function(lineIndex, line) {
			html += '<div class="info">' + line + '</div>';
		  });
		  html += '</div>';
        }
        else if (entry['project']) {
		  html += '<div class="project">';
		  $.each(entry['project'], function(lineIndex, line) {
			html += '<div class="project">' + line + '</div>';
		  });
		  html += '</div>';
        }
        html += '</div>';
        html += '</div>';
        $('#content').append(html);
      });
    });
    return false;
  });
});


$(document).ready(function() {
  $('#roman').click(function() {
    $.getJSON('roman.json', function(data) {
      $('#content').empty();
      $.each(data, function(entryIndex, entry) {
        var html = '<div class="entry">';
        html += '<h3 class="term">' + entry['term'] + '</h3>';
        if (entry['date']) {
          html += '<div class="date">';
          $.each(entry['date'], function(lineIndex, line) {
            html += '<div class="date">' + line + '</div>';
          });
          html += '</div>';
        }
        else if (entry['info']) {
		  html += '<div class="info">';
		  $.each(entry['info'], function(lineIndex, line) {
			html += '<div class="info">' + line + '</div>';
		  });
		  html += '</div>';
        }
        else if (entry['project']) {
		  html += '<div class="project">';
		  $.each(entry['project'], function(lineIndex, line) {
			html += '<div class="project">' + line + '</div>';
		  });
		  html += '</div>';
        }
        html += '</div>';
        html += '</div>';
        $('#content').append(html);
      });
    });
    return false;
  });
});