using System;
using System.Collections;
using System.Threading;
namespace test
{
    class Program
    {   static int num = 5;
        static Thread[] t = new Thread[num];
        static void Main(string[] args)
        {
            for (int i = 0; i < num; i++)
            {
                t[i] = new Thread(AsyncMessage);
                t[i].Start(i);
            }
        }
        static void AsyncMessage(object a)
        {
            Thread.Sleep(3000);
            Console.WriteLine($"index {t[(int)a].ThreadState}");
        }
    }
}
