!function ($) {

    var PlanningBoard = function (element, options) {

        var hasOptions = typeof options == 'object';

    	this.element = $(element);

    	if (hasOptions) {
    		if (typeof options.rooms == 'object')
    			this.rooms = options.rooms;
    		if (typeof options.reservations == 'object')
    			this.reservations = options.reservations;
    		if (typeof options.roomAssignments == 'object')
    			this.roomAssignments = options.roomAssignments;

    		// if (typeof options.planningWindow == 'object')
    		// 	this.planningWindow = options.planningWindow;
    		// if (typeof options.plan == 'object')
    		// 	this.plan = options.plan;

    		if (typeof options.firstDate == 'object')
    			this.firstDate = options.firstDate;
    		if (typeof options.lastDate == 'object')
    			this.lastDate = options.lastDate;

    	}

    	this.renderBackground()
	};

    PlanningBoard.prototype = {

        constructor: PlanningBoard,

        renderBackground: function() {
			// define base dimensions
			var anchor = this.element[0] ;
		    var headerHeight = 30;
		    var rowHeight = 24
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
    		this.paper.path("M"+firstColWidth+" 0L"+firstColWidth+" "+height+
    				"M0 "+headerHeight+"L"+width+" "+headerHeight).attr(
    			{
	            	"stroke":"#999999",
	            	"fill":"none"
	        	});

    		var currentDate = this.firstDate;
    		var index = 0;
    		while (currentDate.diff(this.lastDate) <= 0) {
        		this.paper.path("M"+eval(2*index*cellWidth+firstColWidth)+" 0L"+eval(2*index*cellWidth+firstColWidth)+" "+headerHeight+
            		"M"+eval((2*index+1)*cellWidth+firstColWidth)+" "+Math.floor(headerHeight*0.75)+"L"+eval((2*index+1)*cellWidth+firstColWidth)+" "+headerHeight).attr(
	        	{
	            	"stroke":"#999999",
	            	"fill":"none"
	        	});
		        this.paper.text(eval((2*index+1)*cellWidth+firstColWidth), Math.floor(headerHeight*0.375), currentDate.format("DD.MM"));
		        currentDate = currentDate.add('days',1);
		        index++;
    		}
			
			// draw room names
			this.rooms.forEach( function(item, index) {
				this.paper.text(10, (rowHeight*index+Math.floor(rowHeight/2)+headerHeight), item.name+'['+item.id+']').attr(
		        {
		            "font-family":"arial", 
		            "font-size":"14",
		            "text-anchor":"start"
		        });

				var thisRoomAssignments = this.roomAssignments.filter( function(roomAssignment) {
					return roomAssignment.roomId == item.id;
				});

				var x = headerHeight + index*rowHeight + 2;
				thisRoomAssignments.forEach( function(ra) {
					

				},this);

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
