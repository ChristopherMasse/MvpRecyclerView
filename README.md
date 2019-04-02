### Description

Model-View-Presenter is a popular architectural pattern that allows for the separation of concerns within your Android code. Following the pattern, the UI will be accessed and updated through an interface in order abstract away business logic from the Android classes.

Since RecyclerView requires implementation of Android’s RecyclerView .Adapter and RecyclerView.ViewHolder, business logic and models can easily become coupled to the Android libraries in violation of MVP logic. However, we can avoid this issue by utilizing interfaces to manage the RecyclerView from the presenter layer.

Utilizing such an approach, this sample app will display a RecyclerView containing a list of pets.

### Screenshot
![App screenshot](screenshots/screenshot.png | width=200)

### Details
The separation of concerns between the View and Presentation layer is achieved through the use of a custom **Bindables** interface, which consists of two components:

1. **Bindable.Viewholder**- implemented by RecyclerView.ViewHolder objects in order to bind data from the Presenter to the view 
```java
 interface Viewholder<T>{
    
        void bindItem(T item);
    }
```
2. **Bindable.Presenter**- implemented by the Presenter in MVP pattern in order to provide adapter with information on what type of ViewHolder to display and how many row items to create. By passing an reference of Bindables.Viewholder  in the onBind() method, we can avoid references to the RecyclerView.ViewHolder class within the Presenter.
```java
  interface Presenter<V extends Viewholder>{

        void onBind(int pos, @NonNull V viewholder);

        int getItemCount();

        int getItemViewType(int pos);
    }
```

By implementing these interfaces and adding a reference the Presenter in adapter class, we can manage the list of pets from the Presenter.    

