package com.cyscm.algorithm.linkedList;


/**
 * 实现简单单链表添加
 * @author zhoutao
 */
public class OneWayLinkedList {
    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(-1, "张三");
        HeroNode hero2 = new HeroNode(0, "李四");
        HeroNode hero3 = new HeroNode(-3, "王五");
        HeroNode hero4 = new HeroNode(4, "赵六");

        OneWayLinkedListImpl oneWayLinkedList = new OneWayLinkedListImpl();
        oneWayLinkedList.addHeroOrder(hero1);
        oneWayLinkedList.addHeroOrder(hero4);
        oneWayLinkedList.addHeroOrder(hero4);
        oneWayLinkedList.addHeroOrder(hero2);
        oneWayLinkedList.addHeroOrder(hero3);
        oneWayLinkedList.addHeroOrder(hero3);

        oneWayLinkedList.list();

    }

}


/**
 * 实现单向链表
 * 1：新建类保存单个节点信息及指向下个节点
 * 2：实现新增方法
 */
class OneWayLinkedListImpl{
    /**
     * 定义一个默认的头节点
     */
    HeroNode head = new HeroNode(0, "");

    /**
     * 总是往最后添加元素、没有排序
     * @param heroNode
     */
    public void addHero(HeroNode heroNode){
        if (heroNode == null) {
            System.out.println("heroNode不能为空");
            return;
        }
        //1、定义一个偏移变量
        HeroNode temp = head;

        //2、遍历
        while (true){
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //3、赋值
        temp.next = heroNode;
    }

    /**
     * 添加元素、按no排序
     * @param heroNode
     */
    public void addHeroOrder(HeroNode heroNode){
        if (heroNode == null) {
            System.out.println("heroNode不能为空");
            return;
        }
        //1、定义一个偏移变量，它的层级结构是head、head.next、head.next.next每次都是从head开始循环
        HeroNode temp = head;

        //2、遍历
        while (true){
            if (temp.next == null) {
                break;
            }
            //只能是当前node的下一个node的no跟传入的heroNode的no比较，才能确定位置
            if (temp.next.no > heroNode.no) {
                break;
            }else if (temp.next.no == heroNode.no){
                //避免传入同样的对象，导致next错误，程序死循环
                heroNode = new HeroNode(heroNode.no, heroNode.name);
            }
            temp = temp.next;
        }
        //3、赋值
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    public void list(){
        while (true){
            if (head.next == null) {
                break;
            }
            //记得偏移，不然会死循环
            head = head.next;
            System.out.println(head.toString());
        }
    }


}

class HeroNode{
    public int no;
    public String name;
    public HeroNode next;

    /**
     * 构造方法
     * @param no
     * @param name
     * @return
     */
    HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}