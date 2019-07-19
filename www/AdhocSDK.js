var exec = require('cordova/exec');

var AdhocSDK = {
    /**
     * 获取后台设置的指定的试验变量的值，试验变量的名字注意与后台保持一致
     * 该方法从 SDK 缓存中直接读取，如需同步获取 flag 值，请使用下面的接口
     * 
     * @param {String} flagName adhoc 后台设置的试验变量名字
     * @param {String} defaultValue 指定试验变量的默认值
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    getFlag: function(flagName, defaultValue, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlag", [flagName, defaultValue]);
    },
    
    /**
     * 异步方式从缓存直接获取试验变量的值，并检查更新本地flags数据
     * 
     * @param {String} flagName adhoc 后台设置的试验变量名字
     * @param {String} defaultValue 指定试验变量的默认值
     * @param {Double} timeoutInterval 设置此次网络请求的超时时间，单位为秒(s)，默认 30s
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    getFlagFast: function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getFlagFast", [flagName, defaultValue, timeoutInterval]);
    },

    /**
     * 异步方式从服务器直接获取试验变量的值
     * 
     * @param {String} flagName adhoc 后台设置的试验变量名字
     * @param {String} defaultValue 指定试验变量的默认值
     * @param {double} timeoutInterval 设置此次网络请求的超时时间，单位为秒(s)，默认 30s
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    asynchronousGetFlag: function(flagName, defaultValue, timeoutInterval, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "asynchronousGetFlag", [flagName, defaultValue, timeoutInterval]);
    },

    /**
     * 统计需要的优化指标，用以实现科学有效的测试
     * 
     * @param {String} statName 后台设置的优化指标，名字须保持一致
     * @param {int} statValue 当前优化指标单次统计的权重
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    track: function(statName, statValue, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "track", [statName, statValue]);
    },

    /**
     * 统计需要的优化指标，用以实现科学有效的测试
     * 
     * @param {String} statName 后台设置的优化指标，名字须保持一致
     * @param {int} statValue 当前优化指标单次统计的权重
     * @param {Object} attribute 当前数据的定向条件 { key:value }
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    trackWithAttribute: function(statName, statValue, attribute, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "trackWithAttribute", [statName, statValue, attribute]);
    },

    /**
     *  获取当前设备所在试验的试验名列表
     *  1.数组中只有 CONTROL，代表未进入任何试验
     *  2.数组中存在一个或多个字典，代表进入一个或多个试验
     *   {
     *      id = "试验版本 ID";
     *      name = "试验名称";
     *   }
     * @param {function} successCallback = function (Object) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    getCurrentExperiments: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getCurrentExperiments");
    },
    
    /**
     * 获取 ClientID
     * 
     * @param {function} successCallback = function (String) {} 成功回调
     * @param {function} errorCallback = function (String) {} 错误回调
     */
    getClientID: function(successCallback, errorCallback) {
        exec(successCallback, errorCallback, "AHAdhocPlugin", "getClientID");
    }
};

module.exports = AdhocSDK

