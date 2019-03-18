package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    public ArrayList<String> getPatterns() {
        //TODO Добавить поддержку других паттернов
        return  new ArrayList<>() {{ add("Adapter"); add("Proxy");}};
    }

    public ArrayList<String> getLanguages() {
        //TODO Добавить поддержку других языков
        return  new ArrayList<>() {{ add("Java"); add("C#"); add("JavaScript");}};
    }

    public String generate(int pattern, int language) {
        //TODO Генерировать код для других паттернов и языков
        if( pattern == 0 ) {
            switch (language) {
                case 0:
                    return "public interface Chief {public Object makeBreakfast();public Object makeDinner();public Object makeSupper();}public class Plumber {public Object getPipe(){return new Object();}public Object getKey(){return new Object();}public Object getScrewDriver(){return new Object();}}public class ChiefAdapter implements Chief{private Plumber plumber = new Plumber();@Overridepublic Object makeBreakfast() {return plumber.getKey();}@Overridepublic Object makeDinner() {return plumber.getScrewDriver();}@Overridepublic Object makeSupper() {return plumber.getPipe();}}public class Client {public static void main (String [] args){Chief chief = new ChiefAdapter();Object key = chief.makeDinner();}}";
                case 1:
                    return "\uFEFFusing System;  namespace Adapter {    class MainApp  {    static void Main()    {      Target target = new Adapter();      target.Request();      Console.Read();    }  }   class Target  {    public virtual void Request()    {      Console.WriteLine(\"Called Target Request()\");    }  }   class Adapter : Target  {    private Adaptee adaptee = new Adaptee();     public override void Request()    {      adaptee.SpecificRequest();    }  }   class Adaptee  {    public void SpecificRequest()    {      Console.WriteLine(\"Called SpecificRequest()\");    }  } }";
                default:
                    return "\uFEFFfunction Search (text, word) {var text = text;var word = word;this.searchWordInText = function () {return text;};this.getWord = function () {return word;};};function SearchAdapter (adaptee) {this.searchWordInText = function () {return 'Эти слова ' + adaptee.getWord();+ ' найдены в тексте ' + adaptee.searchWordInText();};};var search = new Search(\"текст\", \"слова\");var searchAdapter = new SearchAdapter(search);searchAdapter.searchWordInText();";
            }
        } else {
            switch (language) {
                case 0:
                    return "public class Main {public static void main(String[] args) {// Create math proxyIMath p = new MathProxy();// Do the mathSystem.out.println(\"4 + 2 = \" + p.add(4, 2));System.out.println(\"4 - 2 = \" + p.sub(4, 2));System.out.println(\"4 * 2 = \" + p.mul(4, 2));System.out.println(\"4 / 2 = \" + p.div(4, 2));}}public interface IMath {public double add(double x, double y);public double sub(double x, double y);public double mul(double x, double y);public double div(double x, double y);}public class Math implements IMath {public double add(double x, double y) {return x + y;}public double sub(double x, double y) {return x - y;}public double mul(double x, double y) {return x * y;}public double div(double x, double y) {return x / y;}}public class MathProxy implements IMath {private Math math;public double add(double x, double y) { if(math == null) {                     math = new Math();                                      }return math.add(x, y);}public double sub(double x, double y) { if(math == null) {                     math = new Math();                                      }return math.sub(x, y);}public double mul(double x, double y) {                if(math == null) {                     math = new Math();                                      }return math.mul(x, y);}public double div(double x, double y) {                if(math == null) {                     math = new Math();                                      }return math.div(x, y);}}";
                case 1:
                    return "using System;using System.Threading;class MainApp{static void Main(){  IMath p = new MathProxy();  Console.WriteLine(\"4 + 2 = \" + p.Add(4, 2));  Console.WriteLine(\"4 - 2 = \" + p.Sub(4, 2));  Console.WriteLine(\"4 * 2 = \" + p.Mul(4, 2));  Console.WriteLine(\"4 / 2 = \" + p.Div(4, 2));  Console.Read();}}public interface IMath{double Add(double x, double y);double Sub(double x, double y);double Mul(double x, double y);double Div(double x, double y);}class Math : IMath{public Math(){    Console.WriteLine(\"Create object Math. Wait...\");    Thread.Sleep(1000);}public double Add(double x, double y){return x + y;}public double Sub(double x, double y){return x - y;}public double Mul(double x, double y){return x * y;}public double Div(double x, double y){return x / y;}}class MathProxy : IMath{Math math;public MathProxy(){  math = null;}public double Add(double x, double y){  return x + y;}public double Sub(double x, double y){  return x - y;}public double Mul(double x, double y){  if (math == null)      math = new Math();  return math.Mul(x, y);}public double Div(double x, double y){  if (math == null)      math = new Math();  return math.Div(x, y);}}";
                default:
                    return "function IMath() {this.add = function(x, y) {};this.sub = function(x, y) {};}function RMath() {this.add = function(x, y) {return x + y;};this.sub = function(x, y) {return x - y;};}RMath.prototype = new IMath();RMath.prototype.constructor = RMath;function MathProxy() {var math = new RMath();this.add = function(x, y) {return math.add(x, y);};this.sub = function(x, y) {return math.sub(x, y);};}var test = new MathProxy();alert(test.add(3, 2)); // 5alert(test.sub(3, 2)); // 1";
            }
        }
    }

}
