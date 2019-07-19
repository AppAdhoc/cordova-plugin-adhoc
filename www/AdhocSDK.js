var exec = require('cordova/exec');

var AdhocSDK = {
    getFlag: function(flagName, defaultValue, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlag", [flagName, defaultValue]);
    },
    
    getFlagFast: function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlagFast", [flagName, defaultValue, timeoutInterval]);
    },
    
    asynchronousGetFlag: function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "asynchronousGetFlag", [flagName, defaultValue, timeoutInterval]);
    },
    
    track: function(statName, statValue, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "track", [statName, statValue]);
    },
    
    trackWithAttribute: function(statName, statValue, attribute, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "trackWithAttribute", [statName, statValue, attribute]);
    },
    
    getCurrentExperiments: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getCurrentExperiments");
    },
    
    getClientID: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getClientID");
    }
};

module.exports = AdhocSDK

