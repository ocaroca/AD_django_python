from django.contrib import admin
from django.urls import path
from rest_framework.routers import DefaultRouter
from imagenes.views import ImagenViewSet

router = DefaultRouter()
router.register(r'imagenes', ImagenViewSet)

urlpatterns = router.urls


urlpatterns += [
    path('admin/', admin.site.urls),
]
