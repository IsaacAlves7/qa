using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using NUnit.Framework.Internal;

namespace TDD_Course
{
    [TestFixture]
    public class LinkedListTests
    {
        [Test]
        public void CreateNode_SetsValueAndNextIsNull()
        {
            ListNode<int> node = new ListNode<int>(1);

            Assert.AreEqual(1, node.Value);
            Assert.IsNull(node.Next);
        }

        [Test]
        public void AddFirst_HeadAndTailAreSame()
        {
            MyLinkedList<int> list = new MyLinkedList<int>();
            list.AddFirst(1);

            Assert.AreEqual(1, list.Head.Value);
            Assert.AreEqual(1, list.Tail.Value);
            Assert.AreSame(list.Head, list.Tail);
        }

        [Test]
        public void AddFirstTwoElements_ListIsInCorrectState()
        {
            var list = new MyLinkedList<int>();
            list.AddFirst(1);
            list.AddFirst(2);

            Assert.AreEqual(1, list.Tail.Value);
            Assert.AreEqual(2, list.Head.Value);
            Assert.AreEqual(2, list.Count);
            Assert.AreSame(list.Head.Next, list.Tail);
        }

        [Test]
        public void AddLast_HeadAndTailAreSame()
        {
            var list = new MyLinkedList<int>();
            list.AddLast(1);

            Assert.AreEqual(1, list.Head.Value);
            Assert.AreEqual(1, list.Tail.Value);
            Assert.AreSame(list.Head, list.Tail);
        }

        [Test]
        public void AddLastTwoElements_ListIsInCorrectState()
        {
            var list = new MyLinkedList<int>();
            list.AddLast(1);
            list.AddLast(2);

            Assert.AreEqual(1, list.Head.Value);
            Assert.AreEqual(2, list.Tail.Value);
            Assert.AreEqual(2, list.Count);
            Assert.AreSame(list.Head.Next, list.Tail);
        }

        [Test]
        public void RemoveFirst_EmptyList_Throws()
        {
            var list = new MyLinkedList<int>();
            Assert.Throws<InvalidOperationException>(() =>
            {
                list.RemoveFirst();
            });
        }

        [Test]
        public void RemoveLast_EmptyList_Throws()
        {
            var list = new MyLinkedList<int>();
            Assert.Throws<InvalidOperationException>(() =>
            {
                list.RemoveLast();
            });
        }

        [Test]
        public void RemoveLast_OneElement_ListIsInCorrectState()
        {
            var list = new MyLinkedList<int>();
            list.AddFirst(1);

            list.RemoveLast();

            Assert.IsNull(list.Head);
            Assert.IsNull(list.Tail);
            Assert.AreEqual(0, list.Count);
        }

        [Test]
        public void RemoveLast_TwoElements_ListIsInCorrectState()
        {
            var list = new MyLinkedList<int>();
            list.AddLast(1);
            list.AddLast(2);

            list.RemoveLast();

            Assert.AreEqual(1, list.Head.Value);
            Assert.AreEqual(1, list.Count);
            Assert.AreSame(list.Head, list.Tail);
        }

        [Test]
        public void RemoveFirst_OneElement_ListIsInCorrectState()
        {
            var list = new MyLinkedList<int>();
            list.AddFirst(1);

            list.RemoveFirst();

            Assert.IsNull(list.Head);
            Assert.IsNull(list.Tail);
            Assert.AreEqual(0, list.Count);
        }
    }

    public class MyLinkedList<T>
    {
        public ListNode<T> Tail { get; private set; }
        public ListNode<T> Head { get; private set; }
        public int Count { get; set; }

        public void AddFirst(T value)
        {
            AddFirst(new ListNode<T>(value));
        }

        private void AddFirst(ListNode<T> node)
        {
            //Save off the head node so we don't lose it
            ListNode<T> temp = Head;
            //Point head to the new node
            Head = node;
            //Insert the rest of the list behind the head
            Head.Next = temp;

            Count++;

            if (Count == 1)
            {
                Tail = Head;
            }
        }

        public void AddLast(T value)
        {
            AddLast(new ListNode<T>(value));
        }

        private void AddLast(ListNode<T> node)
        {
            if (Count == 0)
            {
                Head = node;
            }
            else
            {
                Tail.Next = node;
            }

            Tail = node;

            Count++;
        }

        public void RemoveFirst()
        {
            if (Count == 0)
                throw new InvalidOperationException();

            Head = Head.Next;

            Count--;

            if (Count == 0)
                Tail = null;
        }

        public void RemoveLast()
        {
            if (Count == 0)
                throw new InvalidOperationException();

            if (Count == 1)
            {
                Head = null;
                Tail = null;
            }
            else
            {
                //Before: Head --> 3 --> 5 --> 7
                //        Tail = 7
                //After: Head --> 3 -->5 --> null
                //       Tail = 5
                ListNode<T> current = Head;
                while (current.Next != Tail)
                {
                    current = current.Next;
                }

                current.Next = null;
                Tail = current;
            }

            Count--;
        }
    }

    public class ListNode<T>
    {
        public ListNode(T value)
        {
            Value = value;
        }

        public ListNode<T> Next { get; set; }
        public T Value { get; set; }
    }
}
