$(document).ready(function () {
	$('#dashboard').css('background-color','#ba5e5e').siblings().css('background-color', '#222');
	
	$('.nav li').click(function () {
		$(this).css('background-color','#ba5e5e').siblings().css('background-color', '#222');
	});
	
	$('#notification').click(function () {
		$('#navModal').modal();
	});
	
	$(function () {
		$('a').tooltip();
	});
	
	$('#tabs .active').css('border-bottom','1px solid #337ab7');
	
	$('#tabs li').click(function () {
		$(this).css('background-color', 'white').siblings().css('background-color', 'white');
		$(this).css('border-bottom', '1px solid #337ab7').siblings().css('border-bottom', '1px solid #ddd');
	});
	
	$('.collapse').on('shown.bs.collapse', function () {	
		$(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
		$(this).parent().find(".bottom-radius").removeClass("bottom-radius").addClass("bottom-radius-zero");
	}).on('hidden.bs.collapse', function () {
			$(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
			$(this).parent().find(".bottom-radius-zero").removeClass("bottom-radius-zero").addClass("bottom-radius");
		});		
});

