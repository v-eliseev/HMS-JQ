//=require raphael/raphael.js

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
    		if (typeof options.reservationStatusList == 'object')
    			this.reservationStatusList = options.reservationStatusList;
    		if (typeof options.constraintMatches == 'object')
    			this.constraintMatches = options.constraintMatches;
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
        	var _e
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

    		var currentDate = moment(this.firstDate);
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

    		// mark today
			var x_today = moment().diff(this.firstDate,'days')*2*cellWidth + firstColWidth;
     		this.paper.rect(x_today,0,2*cellWidth,height,0).attr(
     		{
     			"fill":"#ebacee",
     			"stroke":"#7b2080",
     			"opacity":"0.3"
     		});
			
			// draw room names and roomAssignments
			this.rooms.forEach( function(item, index) {
				_e = this.paper.text(10, (rowHeight*index+Math.floor(rowHeight/2)+headerHeight), item.name+'['+item.id+']').attr(
		        {
		            "font-family":"arial", 
		            "font-size":"14",
		            "text-anchor":"start"
		        });
		        _e.node.id = "po_room_"+item.id;

				var thisRoomAssignments = this.roomAssignments.filter( function(roomAssignment) {
					return roomAssignment.roomId == item.id;
				});

				var y = headerHeight + index*rowHeight + 2;
				thisRoomAssignments.forEach( function(ra) {
					var reservations = this.reservations.filter( function(reservation) {
						return ra.reservationId == reservation.id;
					});
					var x_start
					var x_end
					if (reservations.length == 1) {
						x_start = ((moment(reservations[0].fromDate).diff(this.firstDate,'days')+1)*2+1)*cellWidth + 2 + firstColWidth;
						x_end = ((moment(reservations[0].toDate).diff(this.firstDate,'days')+1)*2+1)*cellWidth - 2 + firstColWidth;
					} else {
						alert('Somethig wrong with reservations')
					}

					if (x_start < 0) x_start = 0;
					if (x_end > width) x_end = width;
	
					var constraints = this.constraintMatches.filter( function(constraint) {
						return constraint.roomAssignment.id == ra.id
					});

					var fillColor = "#5bc0de";
					var strokeColor = "#000066";

					_e = this.paper.rect(x_start,y,x_end-x_start,rowHeight-4,2).attr(
					{
						"fill":fillColor,
						"stroke":strokeColor
					});
					_e.node.id = "po_ra_"+ra.id;

					if (constraints.length > 0) {
						_e = this.paper.rect(x_start+1,y+1,rowHeight-6,rowHeight-6,2).attr({
							"fill":"#dd9933",
							"stroke":"none"
						});
						this.paper.text(x_start+rowHeight/2-2,y+rowHeight/2-2,constraints.length).attr({
				            "font-family":"arial", 
				            "font-size":"12"
				        });
				        _e.node.id = "po_cm_"+ra.id;
					}

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
