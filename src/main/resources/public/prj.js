function apply(){
  $('#push').on('click', function(){
    var rx = $('#rx');
  	var ry = $('#ry');
  	var rz = $('#rz');
  	var rt = $('#rt');
  	var move = $('#move');
  	
  	$(rt).val($(rz).val());
  	$(rz).val($(ry).val());
  	$(ry).val($(rx).val());
  	
  	$(move).val(1);
  	
  	
  	
  });
  
  $('[id^="button"]').on('click', function(){
    var rx = $('#rx');
    var move = $('#move');
    if ( $(move).val() == 0 )
    {
        if ( $(rx).val() == 0 )
    	{
       		$(rx).val($(this).val());
    	}
    	else
    	{
    		$(rx).val($(rx).val() + $(this).val());
    	}
    }
    else
    {
    	$(rx).val($(this).val());
    	$(move).val(0);
    }

    
  });
  
  
  $('[id^="operation"]').on('click', function(){
  	var rx = $('#rx');
  	var ry = $('#ry');
  	var rz = $('#rz');
  	var rt = $('#rt');
  	$(move).val(1);
  	
  	var data = JSON.stringify({
  		   "rx": $(rx).val(),
  		   "ry": $(ry).val(),  
  		   "rz": $(rz).val(),  
  		   "rt": $(rt).val(),
  		   "operation" : $(this).val()
  		});
  	$.ajax({
  		type: "POST",
  		url: "/operation",
  		data: data,
  		success: function(data) {
  		  var newdata = JSON.parse(data);
  		  console.log(newdata);
  		  var newrx = newdata.rx;
  		  var newry = newdata.ry;
  		  var newrz = newdata.rz;
  		  var newrt = newdata.rt;
  		  $(rx).val(newrx);
  		  $(ry).val(newry);
  		  $(rz).val(newrz);
  		  $(rt).val(newrt);
  		  
  		}
	});
  });
  
};
$(document).ready(function(){
  // we call the function
  apply();
});