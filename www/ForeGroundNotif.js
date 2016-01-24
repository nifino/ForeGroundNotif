var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "ForeGroundNotif", "coolMethod", [arg0]);
};

s = function(e){};
e = function(e){alert(e);};

exports.start = function() {
	exec( s, e, "ForeGroundNotif", "startFGN", [] );
};

exports.stop = function() {
	exec( s, e, "ForeGroundNotif", "stopFGN", [] );
};

exports.title = function( t ) {
	exec( s, e, "ForeGroundNotif", "updateTitle", [t] );	
};

exports.text = function( m ) {
	exec( s, e, "ForeGroundNotif", "updateText", [m] );	
};

