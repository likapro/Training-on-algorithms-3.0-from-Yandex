package Lesson2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Heapui {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        Heap heap = new Heap();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int comm = Integer.parseInt(tokenizer.nextToken());
            if (comm == 0) {
                int value = Integer.parseInt(tokenizer.nextToken());
                heap.insert(value);
                //System.out.println("insert: " + heap);
            } else {
                buffer.append(heap.extract() + "\n");
                //System.out.println("extract: " + heap);
            }
        }

        System.out.println(buffer);

//        System.out.println(heap);
//        System.out.println(heap.extract());
//        System.out.println(heap);
    }

    private static class Heap {
        private List<Integer> heap = new ArrayList<>();
//        {{
//            add(17237); add(17205); add(17205); add(17176); add(17143); add(15416); add(16520); add(16821); add(15460); add(15333); add(14627); add(9592); add(14850); add(15115); add(15632); add(15360); add(16743); add(15194); add(13676); add(14111); add(14180); add(13175); add(10590); add(8370); add(9187); add(12661); add(11533); add(12196); add(12371); add(14954); add(13969); add(12909); add(12468); add(15463); add(12794); add(14933); add(14297); add(10816); add(13506); add(12787); add(8276); add(11266); add(12457); add(9909); add(8961); add(9783); add(3371); add(2856); add(8317); add(7803); add(8894); add(11272); add(7431); add(2857); add(7313); add(8254); add(11824); add(9744); add(10036); add(12897); add(14493); add(7262); add(8963); add(8618); add(12115); add(9559); add(10585); add(12308); add(13227); add(7560); add(8880); add(11061); add(14020); add(13130); add(6997); add(10547); add(9684); add(12443); add(5097); add(8870); add(12333); add(4665); add(6923); add(9586); add(8634); add(8851); add(2146); add(964); add(9374); add(7634); add(4475); add(3258); add(8229); add(941); add(152); add(2410); add(437); add(4837); add(7085); add(2418); add(608); add(6725); add(3020); add(289); add(4815); add(1177); add(6205); add(496); add(1833); add(1791); add(5451); add(723); add(8177); add(3557); add(10683); add(6180); add(8211); add(1857); add(5257); add(2916); add(10840); add(965); add(12960); add(5050); add(4461); add(2252); add(1367); add(2242); add(6632); add(7399); add(8038); add(6803); add(7083); add(6588); add(6889); add(8758); add(9472); add(9162); add(4646); add(5654); add(2468); add(1137); add(1696); add(8400); add(773); add(5743); add(7896); add(3941); add(1289); add(1064); add(5384); add(8024); add(746); add(6824); add(1107); add(650); add(2393); add(4342); add(4328); add(4057); add(2695); add(4075); add(5294); add(338); add(1034); add(3271); add(4563); add(9131); add(9199); add(2275); add(4880);
//        }};


        private void insert(int n) {
            heap.add(n);
            int index = heap.size()-1;

            while ( index != 0 && heap.get((index-1)/2) < n ) {
                heap.set(index, heap.get((index-1)/2));
                heap.set((index-1)/2, n);
                index = (index-1)/2;
            }
        }

        private int extract() {
            int rez = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            int last = heap.remove(heap.size()-1);
            int index = 0;
            while (index*2+1 < heap.size() ) {
                if (index*2+2 < heap.size()) {
                    if (heap.get(index*2+1) > heap.get(index*2+2) && heap.get(index*2+1) > last) {
                        heap.set(index, heap.get(index*2+1));
                        heap.set(index*2+1, last);

                        index = index*2+1;
                    } else if (heap.get(index*2+2) > last) {
                        heap.set(index, heap.get(index*2+2));
                        heap.set(index*2+2, last);

                        index = index*2+2;
                    } else {
                        return rez;
                    }
                } else {
                    if (heap.get(index*2+1) > last) {
                        heap.set(index, heap.get(index * 2 + 1));
                        heap.set(index * 2 + 1, last);
                    }

                    return rez;
                }
            }

            return rez;
        }

        @Override
        public String toString() {
            String str = "heap: ";
            for(int i : heap) str += i + " ";

            return str;
        }
    }
}
//17237 17205 17205 17176 17143 15416 16520 16821 15460 15333 14627 9592 14850 15115 15632 15360 16743 15194 13676 14111 14180 13175 10590 8370 9187 12661 11533 12196 12371 14954 13969 12909 12468 15463 12794 14933 14297 10816 13506 12787 8276 11266 12457 9909 8961 9783 3371 2856 8317 7803 8894 11272 7431 2857 7313 8254 11824 9744 10036 12897 14493 7262 8963 8618 12115 9559 10585 12308 13227 7560 8880 11061 14020 13130 6997 10547 9684 12443 5097 8870 12333 4665 6923 9586 8634 8851 2146 964 9374 7634 4475 3258 8229 941 152 2410 437 4837 7085 2418 608 6725 3020 289 4815 1177 6205 496 1833 1791 5451 723 8177 3557 10683 6180 8211 1857 5257 2916 10840 965 12960 5050 4461 2252 1367 2242 6632 7399 8038 6803 7083 6588 6889 8758 9472 9162 4646 5654 2468 1137 1696 8400 773 5743 7896 3941 1289 1064 5384 8024 746 6824 1107 650 2393 4342 4328 4057 2695 4075 5294 338 1034 3271 4563 9131 9199 2275 4880
