var exec = require('cordova/exec');

exports.getFlag = function(flagName, defaultValue, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlag", [flagName, defaultValue]);
};

exports.getFlagFast = function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlagFast", [flagName, defaultValue, timeoutInterval]);
};

exports.asynchronousGetFlag = function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "asynchronousGetFlag", [flagName, defaultValue, timeoutInterval]);
};

exports.track = function(statName, statValue, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "track", [statName, statValue]);
};

exports.trackWithAttribute = function(statName, statValue, attribute, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "trackWithAttribute", [statName, statValue, attribute]);
};

exports.getCurrentExperiments = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "getCurrentExperiments");
};

exports.getClientID = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "AHAdhocPlugin", "getClientID");
};