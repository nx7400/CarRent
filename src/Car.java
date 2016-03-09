import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Michał on 03.03.2016.
 */
public class Car extends Vehicle {

    public Car() {

    }

    public Car(String brand, String model, int idWorkShop, int idRental, int pricePerDay) {

        this.idVehicle = id + 1;
        this.brand = brand;
        this.model = model;
        this.idWorkShop = idWorkShop;
        this.idRental = idRental;
        this.pricePerDay = pricePerDay;
        this.itRent = false;

        faultsList = new List<Fault>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Fault> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Fault fault) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Fault> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Fault> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Fault get(int index) {
                return null;
            }

            @Override
            public Fault set(int index, Fault element) {
                return null;
            }

            @Override
            public void add(int index, Fault element) {

            }

            @Override
            public Fault remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Fault> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Fault> listIterator(int index) {
                return null;
            }

            @Override
            public List<Fault> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        inspectionsList = new List<Inspection>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Inspection> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Inspection inspection) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Inspection> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Inspection> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Inspection get(int index) {
                return null;
            }

            @Override
            public Inspection set(int index, Inspection element) {
                return null;
            }

            @Override
            public void add(int index, Inspection element) {

            }

            @Override
            public Inspection remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Inspection> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Inspection> listIterator(int index) {
                return null;
            }

            @Override
            public List<Inspection> subList(int fromIndex, int toIndex) {
                return null;
            }
        };


    }

    @Override
    public void show() {

    }

}
