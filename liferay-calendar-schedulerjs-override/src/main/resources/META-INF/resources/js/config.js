;(function() {

    var base = MODULE_PATH + '/js/';

    AUI().applyConfig(
        {
            groups: {
                calendarscheduleroverride: { //any name
                    base: base,
                    combine: Liferay.AUI.getCombine(),
                    filter: Liferay.AUI.getFilterConfig(),
                    modules: {
                        'liferay-scheduler-override': { //aui module name from override js file
                            path: 'scheduler-override.js', // newly created override file name
                            condition: {
                                name: 'liferay-scheduler-override',//aui module name from override js file
                                trigger: 'liferay-scheduler', //original module
                                when: 'instead'
                            }
                        }
                    },
                    root: base
                }
            }
        }
    );
})();