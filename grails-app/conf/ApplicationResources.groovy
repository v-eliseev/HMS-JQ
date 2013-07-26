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

    resource url:'js/bootstrap/bootstrap-transition.js'
    resource url:'js/bootstrap/bootstrap-alert.js'
    resource url:'js/bootstrap/bootstrap-modal.js'
    resource url:'js/bootstrap/bootstrap-dropdown.js'
    resource url:'js/bootstrap/bootstrap-scrollspy.js'
    resource url:'js/bootstrap/bootstrap-tab.js'
    resource url:'js/bootstrap/bootstrap-tooltip.js'
    resource url:'js/bootstrap/bootstrap-popover.js'
    resource url:'js/bootstrap/bootstrap-button.js'
    resource url:'js/bootstrap/bootstrap-collapse.js'
    resource url:'js/bootstrap/bootstrap-carousel.js'
    resource url:'js/bootstrap/bootstrap-typeahead.js'
    resource url:'js/bootstrap/bootstrap-affix.js'
  }

  bootbox {
    dependsOn 'bootstrap'

    resource url:'js/bootbox/bootbox.min.js'
  }

  daterangepicker {
    dependsOn 'bootstrap'

    resource url:'css/daterangepicker/daterangepicker.css'

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

}