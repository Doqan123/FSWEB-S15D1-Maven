package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<Contact>();

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact newContact) {

        if (myContacts.contains(newContact)) {
            return false;
        } else {
            myContacts.add(newContact);
            return true;
        }
    }

    /*private boolean updateContact(Contact oldContact, Contact newContact){
        if(myContacts.contains(oldContact)){
            myContacts.set(myContacts.indexOf(oldContact), newContact);
            return true;
        } else {
            return false;
        }

    }*/
    //Bu daha verimli çünkü tek bir indeks kontrolu yapılıyor. yukarıdaki kodda 2 kere indeks kontrolu var
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = myContacts.indexOf(oldContact);  // oldContact'in indeksini al
        if (index != -1) {  // Eğer oldContact listede varsa
            myContacts.set(index, newContact);  // oldContact'i newContact ile değiştir
            return true;
        }
        return false;  // oldContact bulunamazsa işlem başarısız
    }

    public boolean removeContact(Contact delContact){
        if(myContacts.contains(delContact)){
            myContacts.remove(delContact);
            return true;
        }else{
            return false;
        }
    }

    public int findContact(Contact contact){
        int index = myContacts.indexOf(contact);
        if(index != -1){
            return index;
        } else {return -1;}
    }

    public int findContact(String name){
        for(int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            if(contact.getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        for (Contact contact : myContacts) {  // myContacts listesindeki her bir öğe için
            if (contact.getName().equalsIgnoreCase(contactName)) {  // İsim eşleşmesi kontrolü
                return contact;  // Eşleşme bulunduğunda ilgili Contact döndürülür
            }
        }
        return null;  // Hiçbir eşleşme bulunamazsa null döndürülür
    }




}
