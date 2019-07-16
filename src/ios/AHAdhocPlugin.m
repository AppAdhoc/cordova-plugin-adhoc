/********* AHAdhocPlugin.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import <AdhocSDKLite/AdhocSDK.h>

@interface AHAdhocPlugin : CDVPlugin

@end

@implementation AHAdhocPlugin

- (void)getFlag:(CDVInvokedUrlCommand*)command {
    CDVPluginResult* pluginResult = nil;
    NSString *flagName = [command.arguments objectAtIndex:0];
    NSString *defaultValue = [command.arguments objectAtIndex:1];
    
    if (flagName != nil && [flagName length] > 0) {
        NSString *flagValue = [AdhocSDK getFlag:flagName default:defaultValue];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:flagValue];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getFlagFast:(CDVInvokedUrlCommand*)command {
    NSString *flagName = [command.arguments objectAtIndex:0];
    NSString *defaultValue = [command.arguments objectAtIndex:1];
    NSTimeInterval timeInterval = [[command.arguments objectAtIndex:2] doubleValue];
    
    if (flagName != nil && [flagName length] > 0) {
        [AdhocSDK getFlagFast:flagName defaultValue:defaultValue timeoutInterval:timeInterval completionHandler:^(id flagValue, NSError *error) {
            CDVPluginResult *pluginResult = nil;
            if (error) {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.description];
            } else {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:flagValue];
            }
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }];
    } else {
        CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

- (void)asynchronousGetFlag:(CDVInvokedUrlCommand*)command {
    NSString *flagName = [command.arguments objectAtIndex:0];
    NSString *defaultValue = [command.arguments objectAtIndex:1];
    NSTimeInterval timeInterval = [[command.arguments objectAtIndex:2] doubleValue];
    
    if (flagName != nil && [flagName length] > 0) {
        [AdhocSDK asynchronousGetFlag:flagName defaultValue:defaultValue timeoutInterval:timeInterval completionHandler:^(id flagValue, NSError *error) {
            CDVPluginResult *pluginResult = nil;
            if (error) {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.description];
            } else {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:flagValue];
            }
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }];
    } else {
        CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

- (void)track:(CDVInvokedUrlCommand*)command {
    NSString *statName = [command.arguments objectAtIndex:0];
    NSNumber *statValue = [command.arguments objectAtIndex:1];
    
    if (statName != nil && [statName length] > 0) {
        [AdhocSDK track:statName value:statValue];
    } else {
        CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

- (void)trackWithAttribute:(CDVInvokedUrlCommand*)command {
    NSString *statName = [command.arguments objectAtIndex:0];
    NSNumber *statValue = [command.arguments objectAtIndex:1];
    id attribute = [command.arguments objectAtIndex:2];
    
    if (statName != nil && [statName length] > 0) {
        [AdhocSDK track:statName value:statValue attribute:attribute];
    } else {
        CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
}

- (void)getCurrentExperiments:(CDVInvokedUrlCommand*)command {
    NSArray *currentExperiments = [AdhocSDK getCurrentExperiments];
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsArray:currentExperiments];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}


- (void)getClientID:(CDVInvokedUrlCommand*)command {
    NSString *clientID = [AdhocSDK getClientID];
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:clientID];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
