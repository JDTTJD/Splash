// IServerInterface.aidl
package com.tuoren.ipc;

// Declare any non-default types here with import statements

interface IServerInterface {
    //  异步
    void executeAsync(String requestKey, String requestParams);

    //  同步
    String executeSync(String requestKey, String requestParams);

}
