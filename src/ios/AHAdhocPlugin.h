//
//  AHAdhocPlugin.h
//
//  Created by appadhoc on 2019/7/11.
//

#import <Cordova/CDV.h>

@interface AHAdhocPlugin : CDVPlugin

- (void)getFlag:(CDVInvokedUrlCommand*)command;
- (void)getFlagFast:(CDVInvokedUrlCommand*)command;
- (void)asynchronousGetFlag:(CDVInvokedUrlCommand*)command;
- (void)track:(CDVInvokedUrlCommand*)command;
- (void)trackWithAttribute:(CDVInvokedUrlCommand*)command;
- (void)getCurrentExperiments:(CDVInvokedUrlCommand*)command;
- (void)getClientID:(CDVInvokedUrlCommand*)command;

@end
