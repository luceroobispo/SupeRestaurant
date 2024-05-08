# SupeRestaurant


Pasos para crear un proyecto Android
1. Importar todas las dependencias y el permiso a internet
2. Crear MyApplication y referenciarlo en AndroidManifest.xml
3. Agregar colores en theme / Color.kt
4. Crear la estructura de packages separados por features(data(local, remote, repository), ui (screens)), core_network, core_database
5. Crear el diseño de las pantallas y la navegacion
6. Llamada a API
      1. Crear el object ApiClient (baseURL) en la carpeta core_network
      2. Crear la clase retrofitFactory en la carpeta core_network
      3. Crear las data class x, xWrapper en la carpeta model
      4. Crear la interfaz del servicio en la carpeta remote
      5. Crear la clase xServiceFactory en la carpeta remote
      6. Crear xRepository en la carpeta repository
7. Dao
      1. Crear la carpeta core_database y el archivo AppDatabase dentro
      2. Ir feature_x y crear RestaurantDao y RestaurantEntity en la carpeta local
      3. Ir feature_x y crear RestaurantDaoFactory en la carpeta remote
8. Cambiar los screens y repository
