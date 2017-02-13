declareEvent();
recalculatePlaceHolders();

function declareEvent()
{
  $(".input-customPlaceholder").bind("input change keydown keypress keyup", function() {
    recalculatePlaceHolders();
  });
}

function recalculatePlaceHolders() {
  $(".input-customPlaceholder").each(function() {
    //console.log("VALUE IN ".concat($(this).attr("placeholder"), " WITH CUSTOM ATTRIBUTE ", $(this).attr("customplaceholder"), " : ", $(this).val()));
    if($(this).attr("customplaceholder") == 0 && $(this).val())
    {
      $("<span class=\"customPlaceHolder\">".concat($(this).attr("placeholder"), "</span>")).insertBefore($(this));
      $(this).attr("customplaceholder", "1");
    }
    if($(this).attr("customplaceholder") == 1 && !$(this).val())
    {
      $valCPH = $(this).attr("placeholder");
      $(".customPlaceHolder").each(function() {
        if($(this).html() == $valCPH)
        {
          $(this).addClass("deleteCustomPlaceHolder");
        }
      });
      $(this).attr("customplaceholder", "0");
    }
    setTimeout(function(){
      $(".deleteCustomPlaceHolder").each(function() {
        $(this).remove();
      });
    }, 500);
  });
}