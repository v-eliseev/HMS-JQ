!function ($) {

    var PlanningBoard = function (element, options) {

        var hasOptions = typeof options == 'object';

    	this.element = $(element);

    	if (hasOptions) {
    		if (typeof options.rooms == 'object')
    			this.rooms = options.rooms;
    		if (typeof options.planningWindow == 'object')
    			this.planningWindow = options.planningWindow;
    		if (typeof options.plan == 'object')
    			this.plan = options.plan;
    	}

    	this.renderBackground()
	};

    PlanningBoard.prototype = {

        constructor: PlanningBoard,

        renderBackground: function() {
			// define base dimensions
			var anchor = this.element[0] ;
		    var headerHeight = 30;
		    rowHeight = 24
			var width = anchor.clientWidth;
			var height = this.rooms.length*rowHeight + headerHeight;
		    var cellWidth = Math.floor((width - 140)/30);
		    var firstColWidth = width - 30*cellWidth;
			this.paper = new Raphael(anchor,width,height); 
			
			// draw panel
			this.paper.rect(0,0,width,height,5).attr(
			{
		        "fill":"#f5f5f5",
		        "stroke":"#999999"
			});
		    
		    // set header
		    this.paper.text(10, Math.floor(headerHeight/2), "Rooms").attr(
		    {
		        "font-family":"arial", 
		        "font-size":"14",
		        "text-anchor":"start"
		    });
    		
    		// draw grid and dates
    		this.planningWindow.forEach( function(item, index) {
        		this.paper.path("M"+eval(2*index*cellWidth+firstColWidth)+" 0L"+eval(2*index*cellWidth+firstColWidth)+" "+height+
            		"M"+eval((2*index+1)*cellWidth+firstColWidth)+" "+Math.floor(headerHeight/2)+"L"+eval((2*index+1)*cellWidth+firstColWidth)+" "+height).attr(
	        	{
	            	"stroke":"#999999",
	            	"stroke-width":"1"
	        	});
		        this.paper.text(eval((2*index+1)*cellWidth+firstColWidth), Math.floor(headerHeight/4), item);
            },this);
			
			// draw room names
			this.rooms.forEach( function(item, index) {
				this.paper.text(10, (rowHeight*index+Math.floor(rowHeight/2)+headerHeight), item.name+'['+item.id+']').attr(
		        {
		            "font-family":"arial", 
		            "font-size":"14",
		            "text-anchor":"start"
		        });
            },this);
	    }
    };

    $.fn.planningboard = function (options) {
        this.each(function () {
            var el = $(this);
            if (!el.data('planningboard'))
                el.data('planningboard', new PlanningBoard(el, options));
        });
        return this;
    };
}(window.jQuery);
