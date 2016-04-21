$(document).ready(function($) {
    $('#sitemap_accordion').find('.sitemap_accordion-toggle').click(function(){

      //Expand or collapse this panel
      $(this).next().slideToggle('normal');

      //Hide the other panels
      //$(".sitemap_accordion-content").not($(this).next()).slideUp('normal');

    });
  });