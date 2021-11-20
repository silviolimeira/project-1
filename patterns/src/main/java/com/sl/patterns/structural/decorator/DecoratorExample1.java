package com.sl.patterns.structural.decorator;

interface ChristmasTree {
    String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }

}

abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    public TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    // standard constructors
    @Override
    public String decorate() {
        return tree.decorate();
    }
}

class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}

class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Garland";
    }
}


public class DecoratorExample1 {

    public static void main(String[] args) {

        ChristmasTree tree1 =
                new Garland(new ChristmasTreeImpl());

        System.out.println(tree1.decorate());

        ChristmasTree tree2 =
            new BubbleLights(
              new Garland(
                 new ChristmasTreeImpl()));

        System.out.println(tree2.decorate());
    }

}
