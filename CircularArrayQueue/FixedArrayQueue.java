package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // TODO why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // TODO
    if (size == capacity) {
      return false;
    }
    rear = (rear + 1)% capacity;
    data[rear] = obj;
    size++;
    return true;
  }


  @Override
  public E peek() {
    // TODO
    return data[front];
  }

  @Override
  public E poll() {
    // TODO
    if (size == 0) {
      return null;
    }
    E obj = data[front];
    data[front] = null;
    front= (front+1)%capacity;
    size--;
    return obj;
  }

  @Override
  public boolean isEmpty() {
    // TODO
    return size == 0;
  }

  @Override
  public int size() {

    return size;
  }


  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    ArrayList<E> list = new ArrayList<>(size);

    for(int i= front; i< front+size;i++)
  {
    var pos = i %capacity;
    list.add(data[pos]);

  }
    return list;
  }
}
