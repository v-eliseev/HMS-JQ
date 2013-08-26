  modules = {
  application {
    resource url:'js/application.js'
  }

  utils {
    resource url:'js/utils.js'
  }

  // jquery {
  //   resource url:'js/jquery/jquery-2.0.2.min.js'
  // }

  // jquery-ui {
  //   dependsOn 'jquery'

  //   resource url:'js/jquery-ui/'
  // }

  core {
	  dependsOn 'jquery, jquery-ui'
  }

  bootstrap {
    dependsOn 'jquery'

    resource url:'less/custom-bootstrap.less', attrs:[rel: "stylesheet/less", type:'css']

    resource url:'js/bootstrap/transition.js'
    resource url:'js/bootstrap/alert.js'
    resource url:'js/bootstrap/button.js'
    resource url:'js/bootstrap/carousel.js'
    resource url:'js/bootstrap/collapse.js'
    resource url:'js/bootstrap/dropdown.js'
    resource url:'js/bootstrap/modal.js'
    resource url:'js/bootstrap/tooltip.js'
    resource url:'js/bootstrap/popover.js'
    resource url:'js/bootstrap/scrollspy.js'
    resource url:'js/bootstrap/tab.js'
    resource url:'js/bootstrap/affix.js'
  }

  bootbox {
    dependsOn 'bootstrap'

    resource url:'js/bootbox/bootbox.min.js'
  }

  daterangepicker {
    dependsOn 'bootstrap'

    resource url:'css/daterangepicker/daterangepicker-bs3.css'

    resource url:'js/daterangepicker/moment.min.js'
    resource url:'js/daterangepicker/daterangepicker.js'
  }

  togglebuttons {
    dependsOn 'bootstrap'

    resource url:'css/togglebuttons/bootstrap-toggle-buttons.css'
    resource url:'js/togglebuttons/jquery.toggle.buttons.js'
  }

   datepicker {
     dependsOn 'bootstrap'

     resource url:'less/datepicker/datepicker.less', attrs:[rel: "stylesheet/less", type:'css']

     resource url:'js/datepicker/bootstrap-datepicker.js'
  //   // TODO add locales

  }

  fullcalendar {
    dependsOn 'jquery'

    resource url:'css/fullcalendar/fullcalendar.css'
    resource url:'js/fullcalendar/fullcalendar.js'
  }

  icons {
    dependsOn 'bootstrap'
    
    resource url:'less/custom-font-awesome.less', attrs:[rel: "stylesheet/less", type:'css']
  }

  chart {
    resource url:'js/chart/Chart.min.js'
  }

  raphael {
    resource url:'js/raphael/raphael-min.js'
  }

  planningboard {
    dependsOn 'jquery, raphael'

    resource url:'js/planningboard/planningboard.js'
  }
  
}