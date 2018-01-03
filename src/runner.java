

public class runner {

    private static final int numOfFirefox= 3;
    private static final int numOfChrome= 3;
    private static final int numOfIE= 3;
    private static final int numOfIos= 2;
    private static final int numOfAndroid= 2;

    public static void main(String[] args) {

        for  (int a=0 ; a<numOfAndroid; a++) {
            myTests test= new myTests(PlatformType.ANDROID, "Android test #"+(a+1));
            Thread t1= new Thread(test);
            t1.start();
        }
        for  (int a=0 ; a<numOfIos; a++) {
            myTests test= new myTests(PlatformType.IOS, "IOS test #"+(a+1));
            Thread t1= new Thread(test);
            t1.start();
        }
        for  (int a=0 ; a<numOfIE; a++) {
            myTests test= new myTests(PlatformType.IE, "IE test #"+(a+1));
            Thread t1= new Thread(test);
            t1.start();
        }
        for  (int a=0 ; a<numOfChrome; a++) {
            myTests test= new myTests(PlatformType.CHROME, "Chrome test #"+(a+1));
            Thread t1= new Thread(test);
            t1.start();
        }
        for  (int a=0 ; a<numOfFirefox; a++) {
            myTests test= new myTests(PlatformType.FIREFOX, "Firefox test #"+(a+1));
            Thread t1= new Thread(test);
            t1.start();
        }

    }

}
