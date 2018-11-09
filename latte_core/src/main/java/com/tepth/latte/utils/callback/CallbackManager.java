package com.tepth.latte.utils.callback;

import java.util.WeakHashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/30
 */
public class CallbackManager {

    private static final WeakHashMap<Object, IGlobalCallback> CALLBACKS = new WeakHashMap<>();

    private static class Holder {
        private final static CallbackManager INSTANCE = new CallbackManager();
    }

    public static CallbackManager getIntance() {
        return Holder.INSTANCE;
    }

    public CallbackManager addCallback(Object tag, IGlobalCallback callback) {
        CALLBACKS.put(tag, callback);
        return this;
    }

    public IGlobalCallback getCallback(Object tag) {
        return CALLBACKS.get(tag);
    }
}
