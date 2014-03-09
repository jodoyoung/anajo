$.ajaxSetup({
	error : function(request, status, error) {
		alert("code:" + request.status + "\n" + "message:"
				+ request.responseText + "\n" + "error:" + error);
	}
});

/**
 * Anajo javascript frame
 * 
 * @param window
 */
(function(window) {

	var Anajo = function() {
		// inner property & method
	};

	Anajo.extend = function(object) {
		for (name in object) {
			Anajo[name] = object[name];
		}
	};

	/**
	 * page control object
	 */
	Anajo.APage = function(pageId) {
		var id = pageId;
		var document = window.document;
		
		var ready = function(fn) {
			$(document).ready(fn);
		};

		return {
			id : id,
			document : document,
			ready : ready
		};
	};

	window.Anajo = window.$A = Anajo;

})(window);

/**
 * Extend
 */
Anajo.extend({
	
	loadWidget : function(path, target, fn) {
		$.ajax({ url: path,
			success: function(result) {
				target = '#' + target;
				$(target).html(result);
				fn && fn();
			}
		});
	},
	
	openLayer : function(path) {
		var height = $(document).height();
		var dimmed = $('<div id="__dimmed__"></div>');
		dimmed.css({'position':'absolute', 'width':'100%', 'height':height, 'z-index':'998', 'background':'#000000', 'opacity':'0.5'});
		$('body').prepend(dimmed);
				
		var layer = $('<div id="__layer__"></div>');
		layer.css({'position':'absolute', 'z-index':'999', 'background':'#ffffff', 'top':'50%', 'left':'50%'});
		$('body').prepend(layer);
		
		if(path) {
			$A.loadWidget(path, '__layer__', function() {
				var layer = $('#__layer__');
				layer.css('margin-left', -(layer.width() / 2));
				layer.css('margin-top', -(layer.height() / 2));
			});
		}
	},
	
	closeLayer : function() {
		$('#__dimmed__').remove();
	},
	
	jsonPost : function(success) {
		$.ajax({
			type : 'POST',
			async : false,
			cache : false,
			contentType : 'application/json; charset=UTF-8',
			dataType : 'json',
			success: success
		});
	},

	submit : function(path, params, method) {
		var form = document.createElement("form");
		form.setAttribute("method", method || "post");
		form.setAttribute("action", path);

		for ( var key in params) {
			if (params.hasOwnProperty(key)) {
				var hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name", key);
				hiddenField.setAttribute("value", params[key]);

				form.appendChild(hiddenField);
			}
		}

		document.body.appendChild(form);
		form.submit();
	}

});