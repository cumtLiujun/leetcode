package ArrayList;

import java.util.Arrays;

public class leastInterval_621 {
    /*
    大佬题解，插入法讲的很细致
    1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
    2、对数组进行排序，优先排列个数（count）最大的任务，
       如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
       则retCount++ ==> A->B->X->A->B->X->A->B
     4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     */

}
