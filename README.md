# Information
- API: https://api.punkapi.com/v2
- Flavors and environments can be created adding properties file to <#project#>/properties
- Each features group is created in a separate and decoupled module with all Clean Architecture layers

# Technical Description
### MVVM
Application was developed using MVVM pattern and Flows as main communication framework

### Clean Architecture
All layers at Clean Architecture except View models to simplify object mapping

### Factory for Preview & Testing
Preview Composables ar test objects are managed by Factory pattern to allow managing different scenarios

### Light & Dark Mode
Light and Dark Mode is implemented using the preferred selection of the user

### Version catalog
Version Catalog is included to improve dependencies management

### Dependencies versions
All versions are up to date