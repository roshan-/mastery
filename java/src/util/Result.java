package util;

/**
 * Created by rdiwakar on 4/16/2017.
 */
public class Result {
    private long result;
    private long timeToCompute;
    private long memoryFootprint;

    public long getTimeToCompute()      { return timeToCompute;     }
    public long getMemoryFootprint()    { return memoryFootprint;   }
    public long getResult()             { return result;            }

    public Result(long _result, long _timeToCompute, long _memoryFootprint) {
        result= _result;
        timeToCompute= _timeToCompute;
        memoryFootprint= _memoryFootprint;
    }
}
