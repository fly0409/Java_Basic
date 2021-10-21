package Map;

import org.junit.Test;

import java.util.HashMap;

/**
 * Map 雙列數據 儲存key value對的數據
 *      |-----HashMap: Map的主要實現類,執行緒不安全,效率高;可以儲存null的 key和value(如果要執行續安全要用Collections的方法)Collections.synchronizedMap
 *              |----LinkedHashMap :遍歷效率較好，可以按照添加的順序遍歷
 *                                  原因：在原有的hashMap上，添加了向前向後的指針
 *      |-----TreeMap：可以按照添加的key-Value 進行排序，實現排序遍歷，考慮key的自然排序或是訂製排序
 *                     底層使用紅黑數
 *      |-----Hashtable: 古老的實現類(類似arraylist & vector);執行續安全,不可以儲存null的 key和value
 *              |----Properties：常用來處理配置檔。key & value 都是String 類型
 *
 *      HashMap 底層  jdk7之前  陣列+linkedList
 *                   jdk8之後  陣列+linedList+紅黑樹(提升效率)
 *
 *
 *     二、Map中結構的理解
 *     Map的key  ：無序的、不重複的，使用set儲存所有key
 *     Map的value：無序的、可以重複，使用collection儲存所有value
 *     一個key-value構成了一個entry物件，兩個屬性，一個key一個value，(不可重複，無順序，對應到set)
 *
 *     三、hashMap 底層分析  (用底層較為簡單的jdk7示範)
 *     new HashMap();
 *     實例化後，創建長度為16的一維陣列 entry[] table
 *     ...再添加了一些data後...
 *     map.put(key1,value1);
 *     首先，調用key1所在類別的hashCode()計算key1的hashValue，在利用hashMap裡的hash()得到要放在array的位置
 *     如果此位置的數據為空，此時的key1 value1 添加成功
 *     如果此位置的數據不為空，意味此位置已經存在一個或多個數據(linked list)，
 *     比較key1 和已經存在的一個或多個的hash值
 *          如果key1 和已經存在的hash值都不相同，就添加成功
 *          如果key1 和已經存在的hash值有相同，調用k1所在類別的equals方法比較
 *              如果equals為false=>添加成功
 *                 equals為true =>使用value 1 去替換本來的value值(所以put有修改的功能...)
 *
 *     擴容問題：再添加過程中的，當超出臨界時(16*0.75)且(放進去的不是新的位置(第13))擴容為原來容量的2倍，並將原有的數據複製過來
 *
 *     jdk8 相較jdk7不同
 *     1. new HashMap不直接創建陣列，且底層陣列改名為Node
 *     2. 首次調用put方法時，底層創建長度為16的陣列
 *     3. 涉及到紅黑樹
 *        當陣列中的某一個索引位置上的元素以linked list方式存放的data超過8比
 *        且當前陣列的長度 > 64時，此索引位置上的所有數據改成紅黑樹儲存=>效率問題
 *
 *     linkedHashMap 繼承hashMap，重寫了newNode()
 *     Entry 新增before/after屬性
 *
 *     補充hashSet.add 調用 hashMap.put(E,PRESENT)
 *     private static final PRESENT=new Object();都指向同一個obj
 */

public class MapDemo {

    @Test
    public void test1(){
        new HashMap<>();
    }

}
