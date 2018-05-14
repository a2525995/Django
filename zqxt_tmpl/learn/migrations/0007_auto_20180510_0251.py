# Generated by Django 2.0.1 on 2018-05-10 02:51

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('learn', '0006_user_permission'),
    ]

    operations = [
        migrations.CreateModel(
            name='News',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('content', models.TextField()),
                ('title', models.CharField(max_length=50)),
                ('time', models.DateField()),
            ],
        ),
        migrations.AlterField(
            model_name='list_info',
            name='img',
            field=models.ImageField(default='img/retina_wood.png', upload_to='img/%Y/%m', verbose_name='Narrow of img'),
        ),
    ]
