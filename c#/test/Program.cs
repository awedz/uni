using System;
using System.Collections;
namespace test
{
    class Program
    {
        static void Main(string[] args)
        {


            Dictionary<string,Queue<string>> arr = new Dictionary<string, System.Collections.Queue<string>>();
            arr["test1"] = new Queue<string>();
            arr["test1"].Enqueue("a1");
            arr["test1"].Enqueue("a2");
            arr["test1"].Enqueue("a3");
            arr["test1"].Enqueue("a4");
            arr["test1"].Enqueue("a5");
            arr["test2"] = new Queue<string>();
            arr["test2"].Enqueue("b1");
            arr["test2"].Enqueue("b2");
            arr["test2"].Enqueue("b3");
            arr["test2"].Enqueue("b4");
            arr["test2"].Enqueue("b5");
            arr["test3"] = new Queue<string>(); 
            arr["test3"].Enqueue("c1");
            arr["test3"].Enqueue("c2");
            arr["test3"].Enqueue("c3");
            arr["test3"].Enqueue("c4");
            arr["test3"].Enqueue("c5");           
            arr.keys.tolist();

            


            Console.WriteLine("Hello World!");




        }
    }
}
