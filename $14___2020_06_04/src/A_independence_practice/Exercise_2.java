package A_independence_practice;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 2、一篇文章拥有一个标题，一个作者和几个标签。
 *
 * 请编写文章（Article）类，且能够对Article类的对象进行迭代，以输出该文
 * 章的每个标签。
 *
 * 编写程序测试Article类。
 *
 */
public class Exercise_2 {
    private static class Test{
        public static void main(String[] args) {
            Articles as = new Articles();

            for (int i = 1; i <= 6; i++) {
                as.add(new Articles.ArticleDetail(
                        "标题",
                        "作者",
                        new String[]{"Number: "+i+"  ==> ","Linux", "Operating System", "Network", "Operating maintenance"}
                        ));
            }

//            Iterator iterator = as.iterator();
//            while (iterator.hasNext()) {
//                for (String tag : ((Articles.ArticleDetail) iterator.next()).tags) {
//                    System.out.print(tag+"/");
//                }
//                System.out.println();
//            }

            for (Object o : as) {
                for (String tag : ((Articles.ArticleDetail) o).tags) {
                    System.out.print(tag+"/");
                }
                System.out.println();
            }
        }
    }

    private static class Articles implements Iterable{
        private LinkedList list;

        {
            list = new LinkedList<ArticleDetail>();
        }

        public Articles() {
        }

        public Articles(ArticleDetail ad) {
            list.add(ad);
        }

        @Override
        public Iterator iterator() {
//            return list.iterator();
            return new AtleItr();
        }

        private class AtleItr implements Iterator<ArticleDetail>{
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return cursor + 1 != list.size();
            }

            @Override
            public ArticleDetail next() {
                return (ArticleDetail)list.get(++cursor);
            }
        }

        public int size() {
            return list.size();
        }

        public int indexOf(ArticleDetail ad) {
            return list.indexOf(ad);
        }

        public ArticleDetail get(int index) {
            return (ArticleDetail)list.get(index);
        }

        public boolean add(ArticleDetail ad) {
            return list.add(ad);
        }

        public void add(int index, ArticleDetail element) {
            list.add(index, element);
        }

        public ArticleDetail remove(int index) {
            return (ArticleDetail)list.remove(index);
        }

        public boolean remove(ArticleDetail ad) {
            return list.remove(ad);
        }

        static class ArticleDetail{
            private String title;
            private String author;
            private String[] tags = {};

            public ArticleDetail() {
            }

            public ArticleDetail(String title, String author, String[] tags) {
                this.title = title;
                this.author = author;
                this.tags = tags;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String[] getTags() {
                return tags;
            }

            public void setTags(String[] tags) {
                this.tags = tags;
            }
        }


    }
}
