public class PaintJob {

    public static int getBucketCount (double width, double height, double areaPerBucket, int extraBuckets){
        if ((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0)) {
            return -1;
        } else if (((areaPerBucket * (width * height)) - extraBuckets) <= 0){
            return 0;
        } else {
            return (int)Math.ceil(((width * height)/areaPerBucket) - extraBuckets);
        }
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket){
        if ((area <= 0) || (areaPerBucket <= 0)){
            return -1;
        } else {
            return (int)Math.ceil(area / areaPerBucket);
        }

    }
}
