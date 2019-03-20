package sample;

import java.util.ArrayList;

public class Generator {

    public ArrayList<String> getPatterns() {
        //TODO Добавить поддержку других паттернов
        return  new ArrayList<String>() {{ add("Adapter"); add("Proxy"); add("Decorator"); add("Composite");}};
    }

    public ArrayList<String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  new ArrayList<String>() {{ add("Java"); add("C#"); add("JavaScript");}};
    }

    public String generate(int pattern, int language) {
        //TODO Генерировать код для других паттернов и языков
        switch( pattern ){

            case  0 :

            switch (language) {
                case 0:
                    return "interface RoundPeg {private int radius;public RoundPeg( int radius );public int " +
                            "getRadius();}class SquarePeg{private int width;public SquarePeg( int width ){this.width " +
                            "= width;}public int getWidth(){return this.width;}}class SquarePegAdapter implements " +
                            "RoundPeg{private SquarePeg peg;public SquarePegAdapter( SquarePeg peg ) {this.peg = peg;}" +
                            "@Overridepublic int getRadius() {return (int)(peg.getWidth() * Math.sqrt(2)/2);}}public " +
                            "class RoundHole {private int radius;public int getRadius() {return this.radius;}public " +
                            "RoundHole( int radius ) {this.redius = radius;}public bool fits( RoundPeg peg ){if( " +
                            "peg.getRadius() <= this.radius )return true;elsereturn false;}}";
                case 1:
                    return "\uFEFFusing System;  namespace Adapter {    class MainApp  {    static void Main()    {" +
                            "      RoundPeg roundPeg = new SquarePegAdapter();      roundPeg.getRadius();      " +
                            "RoundHole hole = new RoundHole(radius);hod.fits(roundPeg);    }  }   class RoundPeg  {    " +
                            "int radius;    public virtual int getRadius()    {      return radius;    }  }   class " +
                            "SquarePegAdapter : RoundPeg  {    private SquarePeg adaptee = new SquarePeg();     public " +
                            "override int getRadius()    {      adaptee.getWidth();    }  }   class SquarePeg  " +
                            "{int width;    public int getWidth()    {      return width;    }  } }";
                default:
                    return "\uFEFFfunction SquarePeg( width ) {var width = width;this.getWidth = function () " +
                            "{return width;};};function SquarePegAdapter ( adaptee ) {this.getRadius = function () " +
                            "{return adaptee.getWidth();};};var squarePeg = new SquarePeg(1);var squareAdapter = new " +
                            "SquareAdapter(squarePeg);squareAdapter.getRadius();";
            }


            case 1:
            switch (language) {
                case 0:
                    return "public class Main {public static void main(String[] args) {ThirdPartyYoutubeLib object " +
                            "= new CachedYoutubeClass(); String[] result = object.listVideos();}}public interface " +
                            "ThirdPartyYoutubeLib {public String[] listVideos();public String getVideoInfo(int id)" +
                            ";public File downloadVideo(int id);}public class ThirdPartyYoutubeClass implements " +
                            "ThirdPartyYoutubeLib {private String[] vieos;public String[] listVideos(){return " +
                            "this.videos;}public String getVideoInfo(int id){return this.videos[ i ];}public File " +
                            "downloadVideo(int id){return new File( videos[ i ] );}}public class CachedYoutubeClass " +
                            "implements ThirdPartyYoutubeLib{private ThirdPartyYoutubeClass service;public " +
                            "CachedYoutubeClass( ThirdPartyYoutubeClass s){this.service = s;}public " +
                            "CachedYoutubeClass(){}public String[] listVideos(){if( service == null ){service = " +
                            "new ThirdPartyYoutubeClass(); }return service.listVideos();}public String getVideoInfo" +
                            "(int id){if( service == null ){service = new ThirdPartyYoutubeClass(); }return service." +
                            "getVideoInfo(id);}public File downloadVideo(int id){if( service == null ){service = new " +
                            "ThirdPartyYoutubeClass(); }return service.downloadVideo(id);}}";
                case 1:
                    return "using System;using System.Threading;class MainApp{static void Main(){  IMath p = new " +
                            "MathProxy();  Console.WriteLine(\"4 + 2 = \" + p.Add(4, 2));  Console.WriteLine(\"4 - " +
                            "2 = \" + p.Sub(4, 2));  Console.WriteLine(\"4 * 2 = \" + p.Mul(4, 2));  Console.WriteLine" +
                            "(\"4 / 2 = \" + p.Div(4, 2));  Console.Read();}}public interface IMath{double add(double " +
                            "x, double y);double Sub(double x, double y);double Mul(double x, double y);double Div(double" +
                            " x, double y);}class Math : IMath{public Math(){    Console.WriteLine(\"Create object Math. " +
                            "Wait...\");    Thread.Sleep(1000);}public double Add(double x, double y){return x + y;}public " +
                            "double Sub(double x, double y){return x - y;}public double Mul(double x, double y){" +
                            "return x * y;}public double Div(double x, double y){return x / y;}}class MathProxy : " +
                            "IMath{Math math;public MathProxy(){  math = null;}public double Add(double x, double y){  " +
                            "return x + y;}public double Sub(double x, double y){  return x - y;}public double Mul(double " +
                            "x, double y){  if (math == null)      math = new Math();  return math.Mul(x, y);}public double " +
                            "Div(double x, double y){  if (math == null)      math = new Math();  return math.Div(x, y);}}";
                default:
                    return "function IMath() {this.add = function(x, y) {};this.sub = function(x, y) {};}function " +
                            "RMath() {this.add = function(x, y) {return x + y;};this.sub = function(x, y) {return x - " +
                            "y;};}RMath.prototype = new IMath();RMath.prototype.constructor = RMath;function MathProxy() " +
                            "{var math = new RMath();this.add = function(x, y) {return math.add(x, y);};this.sub = function" +
                            "(x, y) {return math.sub(x, y);};}var test = new MathProxy();alert(test.add(3, 2));" +
                            " // 5alert(test.sub(3, 2)); // 1";
            }

            case 2:
                switch (language){
                    case 0:
                        return "public interface InterfaceComponent {void doOperation();}class MainComponent " +
                                "implements InterfaceComponent {@Overridepublic void doOperation() {System.out.print" +
                                "(\"World!\");}}abstract class Decorator implements InterfaceComponent {protected " +
                                "InterfaceComponent component;public Decorator (InterfaceComponent c) {component = c;}" +
                                "@Overridepublic void doOperation() {component.doOperation();}public void newOperation() " +
                                "{System.out.println(\"Do Nothing\");}}class DecoratorSpace extends Decorator {public " +
                                "DecoratorSpace(InterfaceComponent c) {super(c);}@Overridepublic void doOperation() " +
                                "{System.out.print(\" \");super.doOperation();}@Overridepublic void newOperation() " +
                                "{System.out.println(\"New space operation\");}}class DecoratorComma extends Decorator " +
                                "{public DecoratorComma(InterfaceComponent c) {super(c);}@Overridepublic void doOperation() " +
                                "{System.out.print(\",\");super.doOperation();}        @Overridepublic void newOperation() " +
                                "{System.out.println(\"New comma operation\");}}class DecoratorHello extends Decorator " +
                                "{public DecoratorHello(InterfaceComponent c) {super(c);}@Overridepublic void doOperation() " +
                                "{System.out.print(\"Hello\");super.doOperation();}@Overridepublic void newOperation() " +
                                "{System.out.println(\"New hello operation\");}}class Main {public static void main " +
                                "(String... s) {Decorator c = new DecoratorHello(new DecoratorComma(new DecoratorSpace" +
                                "(new MainComponent())));c.doOperation();    c.newOperation();    }}";
                    case 1:
                        return "\uFEFFusing System;namespace Decorator{    class MainApp    {        " +
                                "static void Main()        {            ConcreteComponent c = new ConcreteComponent();  " +
                                "          ConcreteDecoratorA dA = new ConcreteDecoratorA();            " +
                                "ConcreteDecoratorB dB = new ConcreteDecoratorB();            dA.SetComponent(c);            " +
                                "dB.SetComponent(dA);            dA.Operation();            Console.WriteLine();            " +
                                "dB.Operation();            Console.Read();        }    }    abstract class Component    {       " +
                                " public abstract void Operation();    }    class ConcreteComponent : Component    {   " +
                                "     public override void Operation()        {            Console.Write(\"Привет\");  " +
                                "      }    }    abstract class Decorator : Component    {        protected Component " +
                                "component;        public void SetComponent(Component component)        {           " +
                                " this.component = component;        }        public override void Operation()      " +
                                "  {            if (component != null)            {                component.Operation();  " +
                                "          }        }    }    class ConcreteDecoratorA : Decorator    {        " +
                                "public override void Operation()        {            base.Operation();        }  " +
                                "  }    class ConcreteDecoratorB : Decorator    {        public override void Operation() " +
                                "       {            base.Operation();            Console.Write(\" Мир!\");        }    }}";
                    default:
                        return "\uFEFFfunction Component() {this.operation = function() { };this.getPrice = function() " +
                                "{ };this.setPrice = function() { };}function ConcreteComponent() {var price = 10;" +
                                "this.operation = function() {price += 4;alert(\"ConcreteComponent.operation, " +
                                "price: \"+ price);};this.getPrice = function() {return price;};this.setPrice = " +
                                "function(val) {price = val;};}ConcreteComponent.prototype = new Component();" +
                                "ConcreteComponent.prototype.constructor = ConcreteComponent;function Decorator() " +
                                "{var component;this.setComponent = function(val) {component = val;};this.getComponent " +
                                "= function() {return component;};this.operation = function() {component.operation();}" +
                                ";this.getPrice = function() {return component.getPrice();};this.setPrice = function(val) " +
                                "{component.setPrice(val);};}Decorator.prototype = new Component();Decorator.prototype." +
                                "constructor = Decorator;function ConcreteDecoratorA() {Decorator.call(this);var operation " +
                                "= this.operation;this.operation = function() {this.setPrice(this.getPrice() + 3);" +
                                "alert(\"ConcreteDecoratorA.operation, price: \"+ this.getPrice());operation();};}" +
                                "function ConcreteDecoratorB() {var dublicate = this;Decorator.call(this);var " +
                                "operation = this.operation;this.operation = function() {this.setPrice(this.getPrice() + " +
                                "1);alert(\"ConcreteDecoratorB.operation, price: \"+ this.getPrice());addedBehavior();" +
                                "operation();};function addedBehavior() {dublicate.setPrice(dublicate.getPrice() + 2);" +
                                "alert(\"addedBehavior, price: \"+ dublicate.getPrice());}}c = new ConcreteComponent();" +
                                "d1 = new ConcreteDecoratorA();d2 = new ConcreteDecoratorB();alert(\"изначальная " +
                                "цена: \" + c.getPrice());d1.setComponent(c);d2.setComponent(d1);d2.operation();alert(\"цена " +
                                "после преобразования: \" + c.getPrice());";

                }

            default:
                switch (language){
                    case 0:
                        return "import java.util.List;import java.util.ArrayList;interface Graphic {    public void print();}class CompositeGraphic implements Graphic {    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();    public void print() {        for (Graphic graphic : mChildGraphics) {            graphic.print();        }    }    public void add(Graphic graphic) {        mChildGraphics.add(graphic);    }    public void remove(Graphic graphic) {        mChildGraphics.remove(graphic);    }}class Ellipse implements Graphic {    public void print() {        System.out.println(\"Ellipse\");    }}public class Program {    public static void main(String[] args) {        Ellipse ellipse1 = new Ellipse();        Ellipse ellipse2 = new Ellipse();        Ellipse ellipse3 = new Ellipse();        Ellipse ellipse4 = new Ellipse();        CompositeGraphic graphic = new CompositeGraphic();        CompositeGraphic graphic1 = new CompositeGraphic();        CompositeGraphic graphic2 = new CompositeGraphic();        graphic1.add(ellipse1);        graphic1.add(ellipse2);        graphic1.add(ellipse3);        graphic2.add(ellipse4);        graphic.add(graphic1);        graphic.add(graphic2);        graphic.print();    }}";
                    case 1:
                        return "\uFEFF  class MainApp  {    static void Main()    {      Composite root = new Composite(\"root\");       root.Add(new Leaf(\"Leaf A\"));      root.Add(new Leaf(\"Leaf B\"));       Composite comp = new Composite(\"Composite X\");       comp.Add(new Leaf(\"Leaf XA\"));      comp.Add(new Leaf(\"Leaf XB\"));      root.Add(comp);      root.Add(new Leaf(\"Leaf C\"));       Leaf leaf = new Leaf(\"Leaf D\");      root.Add(leaf);      root.Remove(leaf);       root.Display(1);       Console.Read();    }  }  abstract class Component  {    protected string name;     public Component(string name)    {      this.name = name;    }    public abstract void Display(int depth);  }   class Composite : Component  {    private List<Component> children = new List<Component>();     // Constructor    public Composite(string name) : base(name)    {      }     public void Add(Component component)    {      children.Add(component);    }     public void Remove(Component component)    {      children.Remove(component);    }     public override void Display(int depth)    {      Console.WriteLine(new String('-', depth) + name);       foreach (Component component in children)      {        component.Display(depth + 2);      }    }  }   class Leaf : Component  {    public Leaf(string name) : base(name)    {      }     public override void Display(int depth)    {      Console.WriteLine(new String('-', depth) + name);    }  }";
                    default:
                        return "\uFEFFfunction Component() {    this.name = '';    this.value = 0;    this.execute = function () { };}function Leaf(name, value) {    this.name = name;    this.value = value;    this.execute = function () {        return this.value;    };}Leaf.prototype = Object.create(Component.prototype);Leaf.prototype.constructor = Leaf;function Composite(name) {    var self = this;    var children = [];    this.name = name;    this.add = function (component) {        children.push(component);    };    this.remove = function (componentName) {        var newChildren = [];        children.forEach(function (component) {            if (component.name !== componentName) {                newChildren.push(component);            }        });        children = newChildren;    };    this.execute = function () {        children.forEach(function (component) {            self.value += component.execute();        });        return self.value;    };}Composite.prototype = Object.create(Component.prototype);Composite.prototype.constructor = Composite;var kitchen = new Composite('Кухня');kitchen.add( new Leaf('Верхняя секция', 5200) );kitchen.add( new Leaf('Верхняя двойная секция', 10000) );kitchen.add( new Leaf('Нижняя секция', 4500) );kitchen.add( new Leaf('Нижняя угловая секция', 7800) );var equipment = new Composite('Техника');equipment.add( new Leaf('Газовая плита', 26400) );equipment.add( new Leaf('Холодильник', 32300) );equipment.add( new Leaf('Посудомойка', 21600) );kitchen.add(equipment);console.log('Итого: ' + kitchen.execute() + ' руб.');";

                }
        }
    }

}
