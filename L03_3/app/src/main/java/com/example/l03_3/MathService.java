package com.example.l03_3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.HashSet;

public class MathService extends Service {
    final private IBinder binder = (IBinder) new SomeBinder();
    public class SomeBinder extends Binder {
        MathService getService() {
            return MathService.this;
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // ...
    }
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public HashSet setUnion(HashSet A, HashSet B) {
        HashSet res = new HashSet();
        for (Object a : A)
            if(!res.contains(a))
                res.add(a);

        for (Object b : B)
            if(!res.contains(b))
                res.add(b);

        return res;
    }

    public HashSet setIntersection(HashSet A, HashSet B) {
        HashSet res = new HashSet();
        for (Object a : A)
            for (Object b : B) {
                if(b.equals(a))
                    res.add(b);
            }
        return res;
    }

    public HashSet setDifference(HashSet A, HashSet B) {
        HashSet res = A;
        HashSet diff = setIntersection(A, B);
        for (Object obj : diff)
            if (res.contains(obj))
                res.remove(obj);
        /*for (Object a : A) {
            boolean found = false;
            for (Object b : B) {
                if (a.equals(b))
                    found = true;
            }
            if (!found)
                res.add(a);
        }*/
        return res;
    }

    public HashSet setSymmetricDifference(HashSet A, HashSet B) {
        HashSet res = setUnion(A, B);
        HashSet diff = setIntersection(A, B);
        for (Object obj : diff)
            if (res.contains(obj))
                res.remove(obj);
        return res;
    }
}
